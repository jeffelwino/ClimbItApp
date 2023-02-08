<template>
  <v-sheet>
    <!-- v-slot:activator="{ on, attrs }"> -->
    <v-btn
      class="light-green"
      small
      @click.stop="dialog = true"
      v-bind:disabled="!isClicked"
    >
      <!-- small v-bind="attrs" v-on="on"> -->
      ClimbedIt!
    </v-btn>

    <v-dialog v-model="dialog" persistent max-width="600px">
      <v-card>
        <v-form class="px-3">
          <v-row class="justify-center">
            <v-card-title class="dark-grey">
              <span class="text-h6 text-md-h5 text-lg-h4 text-truncate"
                >Congrats! Tell us more!</span
              >
            </v-card-title>
          </v-row>
          <v-divider></v-divider>

          <v-row>
            <v-col cols="12" sm="6">
              <label
                for="date-climbed"
                id="date-climbed"
                class="text-h7 text-md-h6 text-lg-h5 text-truncate"
                >Date Climbed:</label
              >
            </v-col>

            <v-col cols="12" sm="6">
              <input
                name="date-climbed"
                id="date-climbed"
                type="date"
                v-model="survey.date"
              />
            </v-col>
          </v-row>

          <v-row class="inline-block">
            <v-col cols="12" sm="6">
              <v-card-text>
                Rating:
                <v-rating
                  v-model="survey.rating"
                  color="yellow darken-3"
                  background-color="grey darken-1"
                  empty-icon="$ratingFull"
                  hover
                  medium
                ></v-rating>
              </v-card-text>
            </v-col>

            <v-col cols="12" sm="6" md="4">
              <v-textarea
                outlined
                label="notes"
                v-model="survey.note"
              ></v-textarea>
            </v-col>
          </v-row>
          <v-row class="justify-space-around">
            <v-btn color="blue darken-1" text @click.prevent="dialog = false">
              Cancel
            </v-btn>

            <v-btn color="blue darken-1" text @click.prevent="saveTick">
              Submit
            </v-btn>
          </v-row>
        </v-form>
      </v-card>
    </v-dialog>
  </v-sheet>
</template>
 


<script>
import tickService from "../../services/TickService.js";

export default {
  name: "tickbox",
  props: ["route", "profile"],

  data() {
    return {
      isClicked: true,
      dialog: false,

      survey: {
        id: 0,
        routeId: this.$route.params.id,
        profileId: this.$store.state.user.id,
        date: "",
        rating: 0,
        note: "",
      },
    };
  },
  methods: {
    // saveTick() {
    //   this.survey.id = this.$store.getters.nextTickId;
    //   this.$store.commit("SAVE_TICK", this.survey);
    //   this.survey = {
    //     id: 0,
    //     profileId: this.$store.state.user.id,
    //     routeId: this.route.id,
    //     date: "",
    //     rating: 0,
    //     note: "",
    //   };
    //   this.dialog = false;
    // },
    saveTick() {
      const newTick = {
        routeId: this.survey.routeId,
        profileId: this.survey.profileId,
        date: this.survey.date,
        rating: this.survey.rating,
        note: this.survey.note,
      };
      console.log(this.survey);
      tickService.post(newTick).then((response) => {
        if (response.status === 201) {
          this.$router.go(0);
        }
      });
      this.resetSurvey();
    },
    resetSurvey() {
      this.survey = {
        id: 0,
        routeId: this.$route.params.id,
        profileId: this.$store.state.user.id,
        date: "",
        rating: 0,
        note: "",
      };
      this.dialog = false;
    },
  },
};
</script>

<style>
</style>