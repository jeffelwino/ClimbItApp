<template>
  <v-card class="mb-5" width="100%">
    <v-textarea
      clearable
      outlined
      v-model="comment.body"
      label="Leave a Comment!"
    >
    </v-textarea>
    <v-btn @click="submitComment">Submit</v-btn>
  </v-card>
</template>

<script>
import commentService from "../../services/CommentService.js";
export default {
  props: ["route"],
  data() {
    return {
      comment: {
        profileId: this.$store.state.user.id,
        routeId: this.$route.params.id,
        body: "",
      },
    };
  },
  methods: {
    submitComment() {
      const newComment = {
        profileId: this.comment.profileId,
        routeId: this.comment.routeId,
        body: this.comment.body,
      };
      commentService.postRouteComment(newComment).then((response) => {
        if (response.status === 201) {
          this.$router.go(0);
        }
      });
      this.comment = {
        profileId: this.$store.state.user.id,
        routeId: this.$route.params.id,
        body: "",
      };
    },
  },
};
</script>

<style>
</style>