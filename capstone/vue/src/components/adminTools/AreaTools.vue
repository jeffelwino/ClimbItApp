<template>
  <v-sheet class="red mb-5">
    <h1>Admin TOOL BAR</h1>
    <v-row class="justify-space-around">
      <!-- 
        40.030787465595026 
        -84.2212916018421 
        -->
      <!-- Edit area info -->
      <v-btn small @click.stop="dialog = true"> Edit Info </v-btn>

      <v-dialog v-model="dialog" persistent max-width="600px">
        <v-card>
          <v-form>
            <v-text-field
              clearable
              label="Area Name"
              v-model="updatedArea.name"
            ></v-text-field>
            <v-text-field
              clearable
              label="Description"
              v-model="updatedArea.description"
            ></v-text-field>

            <v-text-field
              clearable
              label="Area Latitude(North-South)"
              v-model="updatedArea.latitude"
            ></v-text-field>
            <v-text-field
              clearable
              label="Area Longitude(East-West)"
              v-model="updatedArea.longitude"
            ></v-text-field>
            <v-btn @click.stop="saveChanges">Submit</v-btn>
            <v-btn @click.stop="cancelChanges">Cancel</v-btn>
          </v-form>
        </v-card>
      </v-dialog>

      <!-- add crag -->
      <v-btn small @click.stop="dialog2 = true">Add Crag</v-btn>

      <v-dialog v-model="dialog2" persistent max-width="600px">
        <v-card>
          <v-form>
            <v-text-field
              clearable
              label="Crag Name"
              v-model="newCrag.name"
            ></v-text-field>
            <v-text-field
              clearable
              label="description"
              v-model="newCrag.description"
            ></v-text-field>
            <v-text-field
              clearable
              label="Crag Latitude(North-South)"
              v-model="newCrag.position.lat"
            ></v-text-field>
            <v-text-field
              clearable
              label="Crag Longitude(East-West)"
              v-model="newCrag.position.lng"
            ></v-text-field>
            <v-btn @click="saveCrag">Submit</v-btn>
            <v-btn @click="cancelCrag">Cancel</v-btn>
          </v-form>
        </v-card>
      </v-dialog>
    </v-row>
  </v-sheet>
</template>



<script>
export default {
  name: "area-tools",
  data() {
    return {
      dialog2: false,
      dialog: false,
      newCrag: {
        id: 0,
        areaId: parseInt(this.$route.params.id),
        name: "",
        position: {
          lat: "",
          lng: "",
        },
      },
    };
  },
  computed: {
    area() {
      return this.$store.state.areas.find((a) => {
        return a.id == this.$route.params.id;
      });
    },
  },
  methods: {
    //Saves updates to area
    saveChanges() {
      let lat = parseFloat(this.updatedArea.position.lat);
      let lng = parseFloat(this.updatedArea.position.lng);
      console.log(lat);
      this.updatedArea.position = { lat: lat, lng: lng };
      this.$store.commit("UPDATE_AREA", this.updatedArea);
      this.dialog = false;
      this.resetUpdatedArea();
    },

    //helper function. resets area information at submit or cancel or created
    resetUpdatedArea() {
      this.updatedArea = {
        id: this.area.id,
        stateAbbrev: this.area.stateAbbrev,
        name: this.area.name,
        description: this.area.description,
        position: {
          lat: "",
          lng: "",
        },
      };
    },

    //ADDS NEW CRAG TO AREA
    saveCrag() {
      this.newCrag.id = this.$store.getters.nextCragId;
      this.$store.commit("SAVE_CRAG", this.newCrag);
      this.dialog2 = false;
      this.newCrag = {
        id: 0,
        AreaId: this.$route.params.id,
        name: "",
        description: "",
        position: {
          lat: "",
          lng: "",
        },
      };
    },
    cancelChanges() {
      this.dialog = false;
      this.resetUpdatedArea();
    },

    cancelCrag() {
      this.newCrag = {
        id: 0,
        areaId: this.$route.params.id,
        name: "",
        description: "",
        position: {
          lat: "",
          lng: "",
        },
      };
      this.dialog2 = false;
    },
  },
  created() {
    this.resetUpdatedArea();
    this.dialog = false;
    this.dialog2 = false;
  },
};
</script>

<style>
</style>