<template>
  <div>
    <route-submit-comment v-bind:route="route" />
    <h3>Comment</h3>
    <comment-display
      v-for="comment in comments"
      v-bind:key="comment.commentId"
      v-bind:comment="comment"
    />
  </div>
</template>

<script>
import CommentDisplay from "./CommentDisplay.vue";
import RouteSubmitComment from "./RouteSubmitComment.vue";
import commentService from "../../services/CommentService.js";

export default {
  components: { CommentDisplay, RouteSubmitComment },

  data() {
    return {
      comments: [],
    };
  },
  props: ["route"],
  created() {
    commentService.listRouteComments(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        this.comments = response.data;
      }
    });
  },
};
</script>

<style>
</style>