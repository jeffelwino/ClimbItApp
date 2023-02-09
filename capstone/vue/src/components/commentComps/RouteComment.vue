<template>
  <div>
    <v-sheet class="ml-n3" width="107%">
      <route-submit-comment v-bind:route="route" />
      <h3>Comments</h3>
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
      <!-- <v-btn
        class="ml-1 mb-2"
        small
        v-show="this.limit == null"
        @click="toggleLimit"
        >Hide</v-btn
      > -->
    </v-sheet>
  </div>
</template>

<script>
import CommentDisplay from "./CommentDisplay.vue";
import RouteSubmitComment from "./RouteSubmitComment.vue";
import commentService from "../../services/CommentService.js";

export default {
  components: { CommentDisplay, RouteSubmitComment },
  name: "route-comment",

  data() {
    return {
      comments: [],
      /*
       ** limit on number of comments displayed. if this changes, also change
       ** toggleLimit value in methods
       */
      limit: 2,
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