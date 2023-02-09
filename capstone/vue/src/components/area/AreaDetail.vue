<template>
  <div class="area">
    <!-- Description component -->
    <v-card class="my-5 mx-2">
      <h5 class="text--secondary pa-2">
        {{ area.description }}
      </h5>
    </v-card>

    <div class="mb-2 mx-2">
      <h2 class="pl-2 blue white--text">
        Crags in {{ area.name }} ({{ crags.length }}):
      </h2>
      <v-card
        outlined
        class="my-2 py-2 pl-2"
        v-for="crag in crags"
        :key="crag.id"
        @click="$router.push(`/crag/${crag.id}`)"
      >
        {{ crag.name }}
      </v-card>
    </div>
  </div>
</template>

<script>
import locationService from "../../services/LocationService.js";
export default {
  name: "area-detail",
  data() {
    return {
      area: {},
      crags: [],
    };
  },

  created() {
    locationService.getAreaById(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        this.area = response.data;
        locationService.getCragsByArea(this.area.id).then((r) => {
          if (r.status == 200) {
            this.crags = r.data;
          }
        });
      }
    });
  },
};
</script>

<style scoped>
h2 {
  background-color: #f4511e;
}
</style>