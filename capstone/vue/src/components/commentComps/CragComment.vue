<template>
  <div>
    <crag-submit-comment :crag="crag" />
    <h1>Comments</h1>
    <comment-display
      v-for="comment in comments"
      v-bind:key="comment.commentId"
      v-bind:comment="comment"
    />
  </div>
</template>

<script>
import CommentDisplay from "./CommentDisplay.vue";
import CragSubmitComment from "./CragSubmitComment.vue";
import commentService from "../../services/CommentService.js";

export default {
  components: { CragSubmitComment, CommentDisplay },
  props: ["crag"],
  data() {
    return {
      comments: [],
    };
  },
  created() {
    commentService.listCragComments(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        this.comments = response.data;
      }
    });
  },
  // computed: {
  //   comments() {
  //     return this.$store.state.comments.filter((c) => {
  //       return c.cragId == this.crag.id;
  //     });
  //   },
  // },
};
</script>

<style>
</style>