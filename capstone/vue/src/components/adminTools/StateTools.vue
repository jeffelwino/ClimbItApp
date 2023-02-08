<template>
  <v-sheet class="red mb-5">
    <h1>Admin TOOL BAR</h1>
    <v-row class="justify-space-around">
      <!-- add area -->

      <v-btn small @click.stop="dialog = true">Add Area</v-btn>

      <v-dialog v-model="dialog" persistent max-width="600px">
        <v-card>
          <v-form>
            <v-text-field
              clearable
              label="Area Name"
              v-model="newArea.name"
            ></v-text-field>
            <v-text-field
              clearable
              label="description"
              v-model="newArea.description"
            ></v-text-field>
            <v-text-field
              clearable
              label="Area Latitude(North-South)"
              v-model="newArea.latitude"
            ></v-text-field>
            <v-text-field
              clearable
              label="Area Longitude(East-West)"
              v-model="newArea.longitude"
            ></v-text-field>
            <!-- <StateMap v-bind:state="state"/> -->
            <NewAreaFormMap v-bind:state="state" />
            <v-btn @click.stop="saveArea">Submit</v-btn>
            <v-btn @click="cancelArea">Cancel</v-btn>
          </v-form>
        </v-card>
      </v-dialog>
    </v-row>
  </v-sheet>
</template>

<script>
import NewAreaFormMap from "../area/NewAreaFormMap.vue";
import locationService from "../../services/LocationService.js";
//import StateMap from "../stateComponets/StateMap.vue"; <---This was just practice to load the screen!
export default {
  components: { NewAreaFormMap }, // StateMap ^^Same as up top
  name: "state-tools",
  data() {
    return {
      dialog: false,
      // state: {},
      // newArea: {},
    };
  },
  computed: {
    state() {
      return this.$store.state.activeState;
    },
    areas() {
      return this.$store.state.activeAreas;
    },
  },
  created() {
    // this.loadState();
    this.resetNewArea();
    this.dialog = false;
  },
  methods: {
    // loadState() {
    //   locationService
    //     .getStateByAbbrev(this.$route.params.id)
    //     .then((response) => {
    //       if (response.status == 200) {
    //         this.state = response.data;
    //       }
    //     });
    // },
    refreshAreas() {
      locationService.getAreasByState(this.state.abbrev).then((response) => {
        if (response.status == 200) {
          this.$store.commit("SET_ACTIVE_AREAS", response.data);
        }
      });
    },
    saveArea() {
      locationService.saveArea(this.newArea).then((response) => {
        if (response.status == 201) {
          this.refreshAreas();
          this.$router.go(0);
        } else {
          window.alert("Uh-oh, something went wrong!");
        }
        this.$store.commit("RELOAD");
      });
      this.dialog = false;
      this.resetNewArea();
    },
    cancelArea() {
      this.resetNewArea();
      this.dialog = false;
    },
    resetNewArea() {
      this.newArea = {
        id: 0,
        name: "",
        description: "",
        stateAbbrev: this.$route.params.abbrev,
        latitude: "",
        longitude: "",
      };
    },
  },
};
</script>

<style>
</style>