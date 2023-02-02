<template>
  <v-container>
    <v-row justify="center">
      <v-dialog scrollable max-width="300px">
        <template v-slot:activator="{ on, attrs }">
          <v-btn color="primary" dark v-bind="attrs" v-on="on">
            Search Climbing By State
          </v-btn>
        </template>
        <v-card>
          <v-list-item
            v-for="state in $store.state.states"
            v-bind:key="state.name"
          >
            <router-link
              v-bind:to="{
                name: 'state-page',
                params: { abbrev: state.abbrev },
              }"
              >{{ state.name }}</router-link
            >
          </v-list-item>
        </v-card>
      </v-dialog>
    </v-row>


  </v-container>
</template>

<script>
export default {
  name: "state-list",
};
</script>

<style>
</style>