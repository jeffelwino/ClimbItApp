<template>
  <v-sheet class="red mb-5">
       <h1>Admin TOOL BAR</h1> 
      <v-row class="justify-space-around"> 

      <!-- Edit crag info -->
      <v-btn small @click.stop="dialog = true">
        Edit Info
        </v-btn>
        
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


          <v-btn @click.stop="saveChanges">Submit</v-btn>
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

export default {
    name: 'crag-tools',
      data() {
    return {
      dialog2: false,
      dialog: false,
      newWall: {
        id: 0,
        cragId: this.$route.params.id,
        name: "",
        description: "",
      },
    };
  },
    computed: {
    crag() {
      return this.$store.state.crags.find((c) => {
        return c.id == this.$route.params.id;
      });
    },
  },
    methods: {
    //Saves updates to crag
    saveChanges() {
      this.$store.commit("UPDATE_CRAG", this.updatedCrag);
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
        longitude: this.crag.longitude
      };
    },

    //ADDS NEW WALL TO CRAG
    saveWall() {
      this.newWall.id = this.$store.getters.nextWallId;
      this.$store.commit("SAVE_WALL", this.newWall);
      this.dialog2 = false;
      this.newWall = {
        id: 0,
        cragId: this.$route.params.id,
        name: "",
        description: "",
      };
    },
     cancelChanges() {
      this.dialog = false;
      this.resetUpdatedCrag();
    },

    cancelWall(){
        this.newWall = {
        id: 0,
        cragId: this.$route.params.id,
        name: "",
        description: "",
      };
      this.dialog2 = false;

    }
  },
  created() {
    this.resetUpdatedCrag();
    this.dialog = false;
    this.dialog2 = false;
  },


}
</script>

<style>

</style>