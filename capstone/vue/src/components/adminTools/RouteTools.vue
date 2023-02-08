<template>
  <div>
    <v-sheet color="red">
      <h1>Admin TOOL BAR</h1>
      <v-btn @click="deleteRoute()"> Delete Route</v-btn>

      <v-btn @click.stop="dialog = !dialog">Edit Info</v-btn>

      <v-dialog v-model="dialog">
        <v-card>
          <v-form>
            <v-text-field
              clearable
              label="Route Name"
              v-model="updatedRoute.name"
            ></v-text-field>
            <v-text-field
              clearable
              label="Grade"
              v-model="updatedRoute.grade"
            ></v-text-field>
            <v-text-field
              clearable
              label="height"
              v-model="updatedRoute.height"
            ></v-text-field>
            <v-text-field
              clearable
              label="style"
              v-model="updatedRoute.style"
            ></v-text-field>
            <v-text-field
              clearable
              label="protection"
              v-model="updatedRoute.protection"
            ></v-text-field>
            <v-text-field
              clearable
              label="description"
              v-model="updatedRoute.description"
            ></v-text-field>

            <v-btn @click="saveChanges">Submit</v-btn>
            <v-btn @click="cancelChanges">Cancel</v-btn>
          </v-form>
        </v-card>
      </v-dialog>
    </v-sheet>
  </div>
</template>

<script>
import locationService from "../../services/LocationService.js";
export default {
  name: "route-tools",

  data() {
    return {
      dialog: false,
      route: {},
      updatedRoute: {},
    };
  },
  created() {
    this.loadRoute();
    this.dialog = false;
  },
  methods: {
    loadRoute() {
      locationService.getRouteById(this.$route.params.id).then((response) => {
        if (response.status == 200) {
          this.route = response.data;
          this.$store.commit("SET_ACTIVE_ROUTE", this.route);
          this.resetUpdatedRoute();
        }
      });
    },
    deleteRoute() {
      if (
        confirm(
          "Are you sure you want to delete this page? This cannot be undone."
        )
      ) {
        let wallId = this.route.wallId;
        locationService.deleteRoute(this.route.id).then((response) => {
          if (response.status == 204) {
            this.$router.push({ name: "wall", params: { id: wallId } });
          }
        });
      }
    },
    saveChanges() {
      locationService.updateRoute(this.updatedRoute).then((response) => {
        if (response.status == 200) {
          window.alert("Route updated!");
          this.$router.go(0);
        } else {
          window.alert("Uh-oh, something went wrong updating the route");
        }
      });
      this.dialog = false;
      this.resetUpdatedRoute();
    },
    cancelChanges() {
      this.dialog = false;
      this.resetUpdatedRoute();
    },
    resetUpdatedRoute() {
      this.updatedRoute = {
        id: this.route.id,
        wallId: this.route.wallId,
        name: this.route.name,
        grade: this.route.grade,
        height: this.route.height,
        style: this.route.style,
        protection: this.route.protection,
        description: this.route.description,
      };
    },
  },
};
</script>

<style>
</style>