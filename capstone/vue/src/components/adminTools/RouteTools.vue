<template>
  <div>
      <v-sheet color="red">
          <h1>Admin TOOL BAR</h1>
          <v-btn @click="deleteRoutePage(routePage.id)"> Delete Route</v-btn>
          <v-btn @click="showForm= ! showForm">Edit Info</v-btn>


        <v-card v-if="showForm">
      <v-form>
        <v-text-field label="Route Name" v-model="updatedRoute.name"></v-text-field>
        <v-text-field label="Grade" v-model="updatedRoute.grade"></v-text-field>
        <v-text-field label="height" v-model="updatedRoute.height"></v-text-field>
        <v-text-field label="style" v-model="updatedRoute.style"></v-text-field>
        <v-text-field label="protection" v-model="updatedRoute.protection"></v-text-field>
        <v-text-field label="description" v-model="updatedRoute.description"></v-text-field>

        <v-btn @click="saveChanges">Submit</v-btn>
        <v-btn @click="cancelChanges">Cancel</v-btn>
      </v-form>
    </v-card>
      </v-sheet>
  </div>
</template>

<script>
export default {
    name: 'route-tools',
    computed: {
        routePage(){
            return this.$store.state.routes.find(r => {
                return r.id == this.$route.params.id;
            });
        }
    },
     data() {
        return {
            showForm: false,
            updatedRoute: {
                // id: this.$route.params.id,
                // wallId: '',
                // name:'',
                // grade:'',
                // height:'',
                // style: '',
                // protection: '',
                // description:''    
            }

        }
    },
    methods: {
      resetUpdatedRoute(){
          this.updatedRoute = {
          id: this.routePage.id,
          wallId: this.routePage.wallId,
          name:this.routePage.name,
          grade:this.routePage.grade,
          height:this.routePage.height,
          style: this.routePage.style,
          protection: this.routePage.protection,
          description:this.routePage.description    
            };
      },
        deleteRoutePage(id){       
            if(confirm("Are you sure you want to delete this page? This cannot be undone.")){
            let wallId = this.routePage.wallId;
            this.$store.commit('DELETE_ROUTE', id);
            this.$router.push({name: "wall", params: {id: wallId}})
            }  
        },
        saveChanges(){
          this.$store.commit("UPDATE_ROUTE", this.updatedRoute);
          this.showForm = false;
          this.resetUpdatedRoute();
        },
        cancelChanges(){
          this.showForm = false;
          this.resetUpdatedRoute();
        }
    },
    created(){
      this.updatedRoute = {
          id: this.routePage.id,
          wallId: this.routePage.wallId,
          name:this.routePage.name,
          grade:this.routePage.grade,
          height:this.routePage.height,
          style: this.routePage.style,
          protection: this.routePage.protection,
          description:this.routePage.description    
            };
      this.showForm = false;
        
    }

}
</script>

<style>

</style>