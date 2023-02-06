<template>
  <div class="area">
    <div class="weather">
      The weather here the next 5 days is going to be perfect for climbing!
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
export default {
  name: "area-detail",
  props: ["area"],
  computed:{
    crags(){
      return this.$store.state.crags.filter((c) => {
        return c.areaId == this.area.id;
      });
    }
  }


  // data() {
  //   return {
  //     crags: [],
  //   };
  // },
  // methods: {
  //   loadCrags() {
  //     this.$store.state.crags.forEach((crag) => {
  //       if (crag.areaId == this.area.id) {
  //         this.crags.push(crag);
  //       }
  //     });
  //   },
  // },
  // created() {
  //   this.loadCrags();
  // },
};
</script>

<style scoped>
.weather {
  background-color: aqua;
}
</style>