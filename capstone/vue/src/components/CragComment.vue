<template>
  <div>
      <submit-comment/>
      <h1>Comments</h1>
      <comment-display v-for="comment in comments" v-bind:key="comment.commentId" v-bind:comment="comment"/>
  </div>
</template>

<script>
import CommentDisplay from './CommentDisplay.vue'
import SubmitComment from './SubmitComment.vue'

export default {
  components: { SubmitComment, CommentDisplay },
  props: ["crag"],
  data(){
      return {
          comments: []
      }
  },
  methods: {
      loadComments(){
          this.$store.state.comments.forEach((comment) => {
              if(comment.cragId == this.crag.id){
                  this.comments.push(comment);
              }
          });
      }
  },
  created(){
      this.loadComments();
  }  
}
</script>

<style>

</style>