<template>
  <v-sheet class="red mb-5">
    <h1>Admin TOOL BAR</h1>
    <v-row class="justify-space-around">
      <!-- Edit crag info -->
      <v-btn small @click.stop="dialog = true"> Edit Info </v-btn>

      <v-dialog v-model="dialog" persistent max-width="600px">
        <v-card>
          <v-form>
            <v-text-field
              clearable
              label="Crag Name"
              v-model="updatedCrag.name"
            ></v-text-field>
            <v-text-field
              clearable
              label="Description"
              v-model="updatedCrag.description"
            ></v-text-field>
            <v-text-field
              clearable
              label="Crag Latitude(North-South)"
              v-model="updatedCrag.latitude"
            ></v-text-field>
            <v-text-field
              clearable
              label="Crag Longitude(East-West)"
              v-model="updatedCrag.longitude"
            ></v-text-field>

            <v-btn @click.stop="updateCrag">Submit</v-btn>
            <v-btn @click.stop="cancelChanges">Cancel</v-btn>
          </v-form>
        </v-card>
      </v-dialog>

      <!-- add wall -->
      <v-btn small @click.stop="dialog2 = true">Add Wall</v-btn>

      <v-dialog v-model="dialog2" persistent max-width="600px">
        <v-card>
          <v-form>
            <v-text-field
              clearable
              label="Wall Name"
              v-model="newWall.name"
            ></v-text-field>
            <v-text-field
              clearable
              label="description"
              v-model="newWall.description"
            ></v-text-field>
            <v-btn @click="saveWall">Submit</v-btn>
            <v-btn @click="cancelWall">Cancel</v-btn>
          </v-form>
        </v-card>
      </v-dialog>
    </v-row>
  </v-sheet>
</template>

<script>
import locationService from "../../services/LocationService.js";
export default {
  name: "crag-tools",
  data() {
    return {
      dialog2: false,
      dialog: false,
      crag: {},
      updatedCrag: {},
      newWall: {},
    };
  },
  created() {
    this.loadCrag();
    this.dialog = false;
    this.dialog2 = false;
  },
  methods: {
    //Saves updates to crag
    updateCrag() {
      // this.$store.commit("UPDATE_CRAG", this.updatedCrag);
      locationService.updateCrag(this.updatedCrag).then((response) => {
        if (response.status == 200) {
          window.alert("Crag successfully updated");
          this.$router.go(0);
        } else {
          window.alert(
            "Uh-oh, there was a problem updating the crag information"
          );
        }
      });
      this.dialog = false;
      this.resetUpdatedCrag();
    },

    //helper function. resets crag information at submit or cancel or created
    resetUpdatedCrag() {
      this.updatedCrag = {
        id: this.crag.id,
        areaId: this.crag.areaId,
        name: this.crag.name,
        description: this.crag.description,
        latitude: this.crag.latitude,
        longitude: this.crag.longitude,
      };
    },

    //ADDS NEW WALL TO CRAG
    saveWall() {
      locationService.saveWall(this.newWall).then((response) => {
        if (response.status == 201) {
          window.alert("crag saved");
          this.$router.go(0);
        } else {
          window.alert("uh-oh, something went wrong adding the new crag");
        }
      });
      this.cancelWall();
    },
    cancelChanges() {
      this.dialog = false;
      this.resetUpdatedCrag();
    },

    cancelWall() {
      this.newWall = {
        id: 0,
        cragId: this.crag.id,
        name: "",
        description: "",
      };
      this.dialog2 = false;
    },
    loadCrag() {
      locationService.getCragById(this.$route.params.id).then((response) => {
        if (response.status == 200) {
          this.crag = response.data;
          this.$store.commit("SET_ACTIVE_CRAG", this.crag);
          this.resetUpdatedCrag();
          this.cancelWall();
        }
      });
    },
    refreshWalls() {
      locationService.getWallsByCragId(this.crag.id).then((response) => {
        if (response.status == 200) {
          this.$store.commit("SET_ACTIVE_WALLS", response.data);
        }
      });
    },
  },
};
</script>

<style>
</style>