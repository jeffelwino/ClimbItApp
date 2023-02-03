<template>
  <div>
    <v-sheet color="red">
      <h1>Admin TOOL BAR</h1>
      <v-btn @click="deleteRoutePage(routePage.id)"> Delete Route</v-btn>
      <v-btn @click="showForm = !showForm">Edit Info</v-btn>
      <v-card v-if="showForm">
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

<!-- add route form/button -->
      <v-btn @click="createForm = !createForm">Add Route</v-btn>
      <v-card v-if="createForm">
        <v-form>
          <v-text-field
            clearable
            label="Route Name"
            v-model="newRoute.name"
          ></v-text-field>
          <v-text-field
            clearable
            label="Grade"
            v-model="newRoute.grade"
          ></v-text-field>
          <v-text-field
            clearable
            label="height"
            v-model="newRoute.height"
          ></v-text-field>
          <v-text-field
            clearable
            label="style"
            v-model="newRoute.style"
          ></v-text-field>
          <v-text-field
            clearable
            label="protection"
            v-model="newRoute.protection"
          ></v-text-field>
          <v-text-field
            clearable
            label="description"
            v-model="newRoute.description"
          ></v-text-field>
          <v-btn @click="saveRoute">Submit</v-btn>
          <v-btn @click="cancelRoute">Cancel</v-btn>
        </v-form>
      </v-card>
    </v-sheet>
  </div>
</template>

<script>
export default {
  name: "wall-tools",
  data() {
    return {
      createForm: false,
      showForm: false,
      newRoute: {
        id: 0,
        wallId: this.$route.params.id,
        name: "",
        grade: "",
        height: "",
        style: "",
        protection: "",
        description: "",
      },
    };
  },
  methods:{
      saveRoute(){
          this.newRoute.id = this.$store.getters.nextRouteId;
          this.$store.commit("SAVE_ROUTE", this.newRoute);
          this.createForm = false;
          this.newRoute = {
                id: 0,
                wallId: this.$route.params.id,
                name: "",
                grade: "",
                height: "",
                style: "",
                protection: "",
                description: "",
            }
      }
  }
};
</script>

<style>
</style>