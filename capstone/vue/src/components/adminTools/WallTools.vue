<template>
  <div>
    <v-sheet color="red">
      <h1>Admin TOOL BAR</h1> 
      <!-- Turn into a dialogue box -->
      <!--  Delete wall and all child routes in progress -->
      <v-row class="justify-space-around"> 
      <v-btn small @click="deleteWall"> Delete Wall</v-btn>

      <!-- Edit wall info -->
      <v-btn small @click="showForm = !showForm">Edit Info</v-btn>
      <v-card v-if="showForm">
        <v-form>
          <v-text-field
            clearable
            label="Wall Name"
            v-model="updatedWall.name"
          ></v-text-field>
          <v-text-field
            clearable
            label="Description"
            v-model="updatedWall.description"
          ></v-text-field>
          <v-btn @click="saveChanges">Submit</v-btn>
          <v-btn @click="cancelChanges">Cancel</v-btn>
        </v-form>
      </v-card>

      <!-- add route -->
      <v-btn small @click="showCreateForm = !showCreateForm">Add Route</v-btn>
      <v-card v-if="showCreateForm">
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
      </v-row>
    </v-sheet>
  </div>
</template>

<script>
export default {
  name: "wall-tools",
  data() {
    return {
      showCreateForm: false,
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
  computed: {
    wall() {
      return this.$store.state.walls.find((w) => {
        return w.id == this.$route.params.id;
      });
    },
  },
  methods: {
    //Saves updates to wall
    saveChanges() {
      this.$store.commit("UPDATE_WALL", this.updatedWall);
      this.showForm = false;
      this.resetUpdatedWall();
    },

    //helper function. resets wall information at submit or cancel or created
    resetUpdatedWall() {
      this.updatedWall = {
        id: this.wall.id,
        cragId: this.wall.cragId,
        name: this.wall.name,
        description: this.wall.description,
      };
    },

    //ADDS NEW ROUTE TO WALL
    saveRoute() {
      this.newRoute.id = this.$store.getters.nextRouteId;
      this.$store.commit("SAVE_ROUTE", this.newRoute);
      this.showCreateForm = false;
      this.newRoute = {
        id: 0,
        wallId: this.$route.params.id,
        name: "",
        grade: "",
        height: "",
        style: "",
        protection: "",
        description: "",
      };
    },
    // DELETES WALL AND CHILD ROUTES
    deleteWall() {
      if (
        confirm(
          "Are you sure you want to delete this Wall and all routes on it? This cannot be undone!!"
        )
      ) {
        console.log(this.wall);
        let cragId = this.wall.cragId;
        this.$store.state.routes.forEach((r) => {
          if (r.wallId == this.wall.id) {
            this.$store.commit("DELETE_ROUTE", r.id);
          }
        });
        this.$store.commit("DELETE_WALL", this.wall.id);
        this.$router.push({ name: "crag", params: { id: cragId } });
      }
    },
    cancelChanges() {
      this.showForm = false;
      this.resetUpdatedWall();
    },

    cancelRoute(){
        this.newRoute = {
        id: 0,
        wallId: this.$route.params.id,
        name: "",
        grade: "",
        height: "",
        style: "",
        protection: "",
        description: "",
      };
      this.showCreateForm = false;

    }
  },
  created() {
    this.resetUpdatedWall();
    this.showForm = false;
    this.showCreateForm = false;
  },
};
</script>

<style>
</style>