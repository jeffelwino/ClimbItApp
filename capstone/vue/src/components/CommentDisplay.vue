<template>
<!-- this is the structure of what a comment will be -->
    <v-container>
        <v-card elevation="3">
            <v-card-title>
                <v-avatar size=48 color="blue">
                    <v-icon dark>
                        mdi-account-circle
                    </v-icon>
                </v-avatar>
                {{comment.user}}</v-card-title>
            <v-card-text label="body" outlined>{{comment.body}}</v-card-text>
        </v-card>
        <!-- <v-container class="comment">
            <v-text-field clearable=true outlined label = "Leave a comment here" v-model="body"></v-text-field>
            <v-btn type="submit" @click="submitComment">Submit</v-btn>
        </v-container>
        <v-container class="commentBank">
            <v-textarea outlined label = "List of Comments" v-model="bank"></v-textarea>
        </v-container>  -->
    </v-container>  
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
        // loadComment(){
        //     this.$store
        // }
    }
}
</script>

<style>
</style>