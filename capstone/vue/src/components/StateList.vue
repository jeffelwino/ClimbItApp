<template>
  <v-container>

<v-row justify="center">
    <v-dialog
      scrollable
      max-width="300px"
    >
        <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="primary"
          dark
          v-bind="attrs"
          v-on="on"
        
        >
          Search Climbing By State
          
        </v-btn>
        </template>
        <v-card>
        <v-list-item
          v-for="state in $store.state.states"
          v-bind:key="state.name"
        > 
        <router-link v-bind:to="{name: 'state-detail', params: {abbrev: state.abbrev}}">{{ state.name }}</router-link>
        </v-list-item>
        </v-card>



      

    </v-dialog>
    </v-row>

      <!-- <v-simple-table>
          <tbody>
        <tr

        >
          <td>{{ state.name }}</td>
          <td>{{ state.name }}</td>
          <td>{{ state.name }}</td>
          <td>{{ state.name }}</td>
          <td>{{ state.name }}</td>
          
        </tr>
      </tbody>
      </v-simple-table> -->


  </v-container>
</template>

<script>
export default {
    name: "state-list",
}

</script>

<style>

</style>