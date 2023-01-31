<template>
    <div>
        <v-container class="comment">
            <v-text-field outlined label = "Leave a comment here" v-model="body"></v-text-field>
            <v-btn type="submit" @click="submitComment">Submit</v-btn>
        </v-container>
        <v-container class="commentBank">
            <v-textarea outlined label = "List of Comments" v-model="bank"><h2>Person's Name</h2></v-textarea>
        </v-container> 
    </div>  
</template>

<script>
export default {
    name: "comment",
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
        }
    }
}
</script>

<style>
</style>