<template>
  <div>
    <crag-submit-comment :crag="crag" />
    <h1>Comments</h1>
    <comment-display
      v-for="comment in limitedList"
      v-bind:key="comment.commentId"
      v-bind:comment="comment"
    />
    <v-btn
      class="ml-1 mb-2"
      :class="{ active: seeAll }"
      small
      @click="toggleLimit"
      >{{ seeAll ? "HIDE" : "SEE ALL" }}
    </v-btn>
  </div>
</template>

<script>
import CommentDisplay from "./CommentDisplay.vue";
import CragSubmitComment from "./CragSubmitComment.vue";
import commentService from "../../services/CommentService.js";

export default {
  name: "crag-comment",

  components: { CragSubmitComment, CommentDisplay },
  props: ["crag"],
  data() {
    return {
      comments: [],
      limit: 2,
      seeAll: false,
    };
  },
  computed: {
    limitedList() {
      return this.limit ? this.comments.slice(0, this.limit) : this.comments;
    },
  },
  methods: {
    toggleLimit() {
      //see note above limit property
      if (this.limit !== null) {
        this.limit = null;
      } else {
        this.limit = 2;
      }
      this.seeAll = this.seeAll ? false : true;
    },
  },
  created() {
    commentService.listCragComments(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        this.comments = response.data;
      }
    });
  },
};
</script>

<style>
</style>