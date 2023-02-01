<template>
    <v-sheet>
    <v-btn class= "light-green" small @click="pressed=!pressed">
      ClimbEdIt!
    </v-btn>
<v-card v-if="pressed==true">
  <v-form>
    <v-card-title class="text-center">
        <h2>Congrats! Tell us more!</h2>
    </v-card-title>
</v-form>
</v-card>

    </v-sheet>

</template>

<script>
export default {
    name: 'tickbox',
    
    data(){
        return{
            pressed: false,
            survey: {
            routeName: '',
            date: '',
            rating: 0,
            notes:''
        },
        }
    }

}
</script>

<style>

</style>