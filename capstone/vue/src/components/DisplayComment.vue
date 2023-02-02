<template>
    <div>
        <v-card>
            <v-card-title>Leave a comment here!</v-card-title>
            <v-text-field clearable=true outlined>
            </v-text-field>
            <v-btn block @click="submitComment">Submit</v-btn>
        </v-card>
        <comment-container v-for="comment in $store.state.comments" v-bind:key="comment.id"/>
    </div>
</template>

<script>
import CommentContainer from './CommentContainer.vue'

export default {
  components: { CommentContainer },
  props: ["comments"],
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