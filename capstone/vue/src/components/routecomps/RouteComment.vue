<template>
    <div>
        <submit-comment v-bind:subject="subject" :route="route"/>
        <h1>Comments</h1>
        <comment-display v-for="comment in comments" v-bind:key="comment.commentId" v-bind:comment="comment"/>
    </div>
</template>

<script>
import CommentDisplay from '../CommentDisplay.vue'
import SubmitComment from '../SubmitComment.vue';

export default {
  components: { CommentDisplay, SubmitComment },
  
  data(){
      return {
        //  comments: [],
          subject: "route"
      }
  }, props: ['route'],
  computed: {
      comments(){
        return this.$store.state.comments.filter(c => {
            return c.routeId == this.route.id;
        })
      }
  },
  methods: {
    //     loadComments(){
    //         this.$store.state.comments.forEach((comment) => {
    //        // let comment = { commentId: commentObj.commentId, routeId: commentObj.routeId, user: commentObj.user, body: commentObj.body }

               
    //         if (comment.routeId == this.route.id){
    //             this.comments.push(comment);
    //         }
    //     });            // this.comments=this.$store.state.comments;
    // }
},
    created(){
        this.loadComments();
    }
}

</script>

<style>

</style>