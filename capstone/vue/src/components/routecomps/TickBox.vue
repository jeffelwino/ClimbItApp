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
          <v-card-title class="dark-grey">
            <span class="text-h4">Congrats! Tell us more!</span>
          </v-card-title>
          <v-divider></v-divider>
          <v-row class="justify-center">
            <v-col cols="12" sm="6" md="3">
              <v-card-text outlined v-bind:key="survey.routeName"
                >{{ survey.routeName }}
              </v-card-text>
            </v-col>
            <v-col cols="12" sm="6" md="3">
              <label for="date-climbed" id="date-climbed">Date Climbed:</label>
              <input
                class="mt-5 ml-2"
                name="date-climbed"
                id="date-climbed"
                type="date"
                v:model="survey.dateClimbed"
              />
            </v-col>
          </v-row>
          <v-row class="inline-block">
            <v-col cols="12" sm="6" md="3">
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
            <v-col cols="12" sm="6" md="3">
              <v-textarea
                outlined
                label="notes"
                v:model="survey.notes"
              ></v-textarea>
            </v-col>
          </v-row>
          <v-row class="justify-space-around">
            <v-btn color="blue darken-1" text @click="dialog = false">
              Cancel
            </v-btn>

            <v-btn color="blue darken-1" text @click="dialog = false">
              Submit
            </v-btn>
          </v-row>
        </v-form>
      </v-card>
    </v-dialog>
  </v-sheet>
</template>

<script>
export default {
  name: "tickbox",
  data() {
    return {
      dialog: false,

      survey: {
        routeName: "",
        dateClimbed: "",
        rating: 0,
        notes: "",
      },
    };
  },

  methods: {
    addSurvey() {
      this.dialog = false;
      this.survey = {
        routeName: "",
        dateClimbed: "",
        rating: 0,
        notes: "",
      };
    },
  },
};
</script>

<style>
</style>