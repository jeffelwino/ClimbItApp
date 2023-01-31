<template>
    <div>
        <v-container class="comment">
            <v-text-field outlined label = "Leave a comment here" v-model="body"></v-text-field>
            <v-btn type="submit" @click="submitComment">Submit</v-btn>
        </v-container>
        <v-container class="commentBank">
            <v-textarea outlined label = "List of Comments" v-model="bank" v-for="comments in $store.state.comments" v-bind:key="comments.user"></v-textarea>
        </v-container> 
    </div>  
</template>

<script>
export default {
    name: "comment",
    props: ["comment"],
    data(){
        return{
            body: '',
            bank: ''
        }
    },
    methods: {
        submitComment(){
            //alert("This is doing something");
            this.bank = this.body;

            // this.$store.comments.name;
            // this.$store.comments.body;
        }
    }
}
</script>

<style>
</style>