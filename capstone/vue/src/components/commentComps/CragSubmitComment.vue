<template>
  <v-card class="mb-5">
    <v-card-title>Leave a comment here!</v-card-title>
    <v-text-field clearable outlined v-model="comment.body"> </v-text-field>
    <v-btn @click="submitComment">Submit</v-btn>
  </v-card>
</template>

<script>
import commentService from "../../services/CommentService.js";
export default {
  props: ["crag"],
  data() {
    return {
      comment: {
        profileId: this.$store.state.user.id,
        cragId: this.$route.params.id,
        body: "",
      },
    };
  },
  methods: {
    submitComment() {
      const newComment = {
        profileId: this.comment.profileId,
        cragId: this.comment.cragId,
        body: this.comment.body,
      };
      commentService.postCragComment(newComment).then((response) => {
        if (response.status === 201) {
          this.$router.go(0);
        }
      });
      this.comment = {
        profileId: this.$store.state.user.id,
        cragId: this.$route.params.id,
        body: "",
      };
    },
  },
};
</script>

<style>
</style>