<template>
  <v-card>
        <v-card-title>Leave a comment here!</v-card-title>
        <v-text-field clearable outlined v-model="newComment.body">
        </v-text-field>
            <v-btn block @click="submitComment">Submit</v-btn>
        </v-card>
</template>

<script>
export default {
    props: ["subject", "route", "crag"],
    data(){
        return {
            newComment: {
                commentId: 0,
                profile_id: this.$store.state.user.id,
                body: ""
            }
        }
    },
    methods: {
        submitComment(){
            if (this.subject == "route"){
                this.newComment.commentId = this.$store.getters.nextCommentId;
                this.newComment.routeId = this.route.id
            }

            if (this.subject == "crag") {
                this.newComment.commentId = this.$store.getters.nextCommentId;
                this.newComment.cragId = this.crag.id
            }

            this.$store.commit("SAVE_COMMENT", this.newComment)
            this.newComment = {
                commentId: 0,
                profile_id: this.$store.state.user.id,
                body: ""
            }
        }
    }
}
</script>

<style>

</style>