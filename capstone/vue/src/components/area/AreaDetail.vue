<template>
  <div class="area">
    <div class="weather">
      The weather here the next 5 days is going to be perfect for climbing!
      <!--Find a way to display the weather!-->
    </div>
    <!-- Description component -->
    <p>{{ area.description }}</p>
    <h2>Here are the crags available to climb at in this area:</h2>
    <ul>
      <li v-for="crag in crags" :key="crag.id">
        <router-link :to="{ name: 'crag', params: { id: crag.id } }">{{
          crag.name
        }}</router-link>
      </li>
    </ul>
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
.weather {
  background-color: aqua;
}
</style>