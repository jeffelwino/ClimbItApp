<template>
  <v-sheet>
    <v-dialog v-model="dialog" persistent max-width="600px">

      <template v-slot:activator="{ on, attrs }">
        <v-btn class="light-green" small v-bind="attrs" v-on="on">
          ClimbedIt!
        </v-btn>
      </template>

      <v-card>
        <v-form class="px-3">
          <v-row class="justify-center">
          <v-card-title class="dark-grey">
            
            <span class="
            text-h6
            text-md-h5
            text-lg-h4
            text-truncate"
            >Congrats! Tell us more!</span>
            
          </v-card-title>
          </v-row>
          <v-divider></v-divider>
          
          <v-row >
            <v-col cols="12" sm="6" md="6" lg="6" xl="6">
              <label for="date-climbed" id="date-climbed" class="
              text-h7
              text-md-h6
              text-lg-h5
              text-truncate" 
              >Date Climbed:</label>
            </v-col>
          
            <v-col cols="12" sm="6" md="6" lg="6" xl="6">
              <input
                name="date-climbed"
                id="date-climbed"
                type="date"
                v-model="survey.date"
              />
            </v-col>
            
          </v-row>

          <v-row class="inline-block">
            <v-col cols="12" sm="6" md="6" lg="6" xl="6">
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
          
            <v-col cols="12" sm="6" md="4" lg="4">
              <v-textarea
                outlined
                label="notes"
                v-model="survey.note"
              ></v-textarea>
            </v-col>

          </v-row>
          <v-row class="justify-space-around">
            <v-btn color="blue darken-1" text @click="dialog = false">
              Cancel
            </v-btn>

            <v-btn color="blue darken-1" text @click="saveTick"> Submit </v-btn>
          </v-row>
        </v-form>
      </v-card>
    </v-dialog>
  </v-sheet>
</template>

<script>
export default {
  name: "tickbox",
  props: ['route'],

  data() {
    return {
      dialog: false,
      // To-do: Similar to principle, set profile_id to logged in user's profile_id
      survey: {
        id: 0,
        profile_id: this.$store.state.user.id,
        routeId: this.route.id,
        date: "",
        rating: 0,
        note: "",
      },
    };
  },
  methods: {
    saveTick() {
      this.survey.id = this.$store.getters.nextTickId;
      this.$store.commit("SAVE_TICK", this.survey);
      this.survey = {
        id: 0,
        profile_id: this.$store.state.user.id,
        routeId: this.route.id,
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