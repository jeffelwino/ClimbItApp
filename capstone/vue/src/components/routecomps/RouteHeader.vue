<template>
 <div class="route-header">
     <!-- route name and grade box -->
     <v-container class="blue">

     <v-row class="justify-center blue">
         <h3 class="white--text">
        {{ route.name }} ({{ route.grade }})
        </h3>
    
     </v-row>
     <v-row class="mt-10 justify-center">
    <v-btn>
      ClimbedIt!
    </v-btn>
     </v-row>

      
     <v-card class="blue">
            

     </v-card>
       
    

     </v-container>
    
     <!-- tick box button -->
     <!-- add to to-do list button -->

 </div>
</template>

<script>
export default {
    name: 'route-header',
    props: ["route"],

}
</script>

<style>

</style>