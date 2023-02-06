<template>
  <div>
    <submit-comment v-bind:subject="subject" :route="route" />
    <h3>Comment</h3>
    <comment-display
      v-for="comment in comments"
      v-bind:key="comment.commentId"
      v-bind:comment="comment"
    />
  </div>
</template>

<script>
import CommentDisplay from "../CommentDisplay.vue";
import SubmitComment from "../SubmitComment.vue";

export default {
  components: { CommentDisplay, SubmitComment },

  data() {
    return {
      subject: "route",
    };
  },
  props: ["route"],
  computed: {
    comments() {
      return this.$store.state.comments.filter((c) => {
        return c.routeId == this.route.id;
      });
    },
  },
};
</script>

<style>
</style>