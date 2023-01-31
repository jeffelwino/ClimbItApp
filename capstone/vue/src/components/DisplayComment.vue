<template>
    <div>
        <comment-container v-for="comment in $store.state.comments" v-bind:key="comment.id"/>
    </div>
</template>

<script>
import CommentContainer from './CommentContainer.vue'

export default {
  components: { CommentContainer },

}
</script>

<style>

</style>