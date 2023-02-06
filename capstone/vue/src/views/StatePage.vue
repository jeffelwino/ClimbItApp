<template>
<v-container>
    <state-tools v-if="this.$store.state.user.authorities[0].name =='ROLE_ADMIN'" />
  <div>
    <state-info />
    </div>
  </v-container>
</template>

<script>
import StateInfo from "../components/stateComponets/StateInfo";
import StateTools from '../components/adminTools/StateTools.vue';


export default {
  name: "state-page",
  components: {StateInfo, StateTools},
  data(){
    return{
        state: {
        abbrev: "",
        name: "",
        areas: 0,
        latitude: "",
        longitude: ""
      },
    };
  },
  methods: {
        loadState() {
      this.state = this.$store.state.states.find((s) => {
        return s.abbrev == this.$route.params.abbrev;
      });
    },

  },
  created() {
    this.loadState();
  },
};
</script>

<style>
</style>