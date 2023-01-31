<template>
  <v-container>

      <v-simple-table>
          <tbody>
        <tr
          v-for="state in $store.state.states"
          v-bind:key="state.name"
        >
          <td>{{ state.name }}</td>
          <td>{{ state.name }}</td>
          <td>{{ state.name }}</td>
          <td>{{ state.name }}</td>
          <td>{{ state.name }}</td>
          
        </tr>
      </tbody>
      </v-simple-table>


  </v-container>
</template>

<script>
export default {
    name: "state-list",

}
</script>

<style>

</style>