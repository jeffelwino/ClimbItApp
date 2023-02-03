<template>
  <div>
    <v-sheet color="red">
      <h1>Admin TOOL BAR</h1>
      <!--  Delete wall and all child routes in progress -->
      <v-btn @click="deleteWall"> Delete Wall</v-btn>

      <!-- Edit wall info -->
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

<!-- add route -->
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
  },  computed: {
    wall(){
      return this.$store.state.walls.find(w => {
        return w.id == this.$route.params.id;
      });
    }
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
      },
        // DELETES WALL AND CHILD ROUTES 
      deleteWall(){
           if(confirm("Are you sure you want to delete this Wall and all routes on it? This cannot be undone!!")){
               console.log(this.wall);
               let cragId = this.wall.cragId;
                this.$store.state.routes.forEach((r) => {
                    if(r.wallId == this.wall.id){
                        this.$store.commit('DELETE_ROUTE', r.id);
                    }
                });
            this.$store.commit('DELETE_WALL', this.wall.id);
            this.$router.push({name: "crag", params: {id: cragId}})
            }  

      }
  }
};
</script>

<style>
</style>