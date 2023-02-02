<template>
  <v-card>
        <v-card-title>Leave a comment here!</v-card-title>
        <v-text-field clearable outlined>
        </v-text-field>
            <v-btn block @click="submitComment">Submit</v-btn>
        </v-card>
</template>

<script>
export default {
      methods: {
        submitComment(){
            //alert("This is doing something");
            this.bank = this.body;

            // this.$store.comments.name;
            // this.$store.comments.body;
        }
}
}
</script>

<style>

</style>