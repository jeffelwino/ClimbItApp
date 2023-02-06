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
            <v-btn @click.stop="saveArea">Submit</v-btn>
            <v-btn @click="cancelArea">Cancel</v-btn>
          </v-form>
        </v-card>
      </v-dialog>
    </v-row>
  </v-sheet>
</template>

<script>
export default {
    name: "state-tools",
  data() {
    return {
      dialog: false,
      newArea: {
        id: 0,
        name: "",
        stateAbbrev: this.$route.params.abbrev,
        latitude: "",
        longitude: ""
      },
    };
  },
  computed: {
    estado() {
      return this.$store.state.states.find((s) => {
        return s.abbrev == this.$route.params.abbrev;
      });
    },
  },
  methods: {
    //ADDS NEW AREA TO STATE
    saveArea() {
      this.newArea.id = this.$store.getters.nextAreaId;
      this.$store.commit("SAVE_AREA", this.newArea);
      this.dialog = false;
      this.newArea = {
        id: 0,
        name: "",
        stateAbbrev: this.$route.params.abbrev,
        latitude: "",
        longitude: ""
      };
    },

    cancelArea() {
      this.newArea = {
        id: 0,
        name: "",
        stateAbbrev: this.$route.params.abbrev,
        latitude: "",
        longitude: ""
      };
      this.dialog = false;
    }

  },
  created() {
    this.dialog = false;
  },
};

</script>

<style>

</style>