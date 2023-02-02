<template>
    <div>
        <submit-comment/>
        <h1>Comments</h1>
        <comment-display v-for="comment in comments" v-bind:key="comment.commentId" v-bind:comment="comment"/>
    </div>
</template>

<script>
import CommentDisplay from '../CommentDisplay.vue'
import SubmitComment from '../SubmitComment.vue';

export default {
  components: { CommentDisplay, SubmitComment },
  props: ["route"],
  data(){
      return {
          comments: [],
      }
  },
  methods: {
        submitComment(){
            //alert("This is doing something");
            this.bank = this.body;

            // this.$store.comments.name;
            // this.$store.comments.body;
        },
        loadComments(){
            this.$store.state.comments.forEach((comment) => {
           // let comment = { commentId: commentObj.commentId, routeId: commentObj.routeId, user: commentObj.user, body: commentObj.body }

               
            if (comment.routeId == this.route.id){
                this.comments.push(comment);
            }
        });            // this.comments=this.$store.state.comments;
    }
},
    created(){
        this.loadComments();
    }
}

</script>

<style>

</style>