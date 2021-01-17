import React from "react";
import { Text, ImageBackground, TouchableOpacity, StyleSheet } from "react-native";
const NewsCard = (props) => {
    const { data, navigation } = props;
    return (
        <TouchableOpacity style={Styles.container} onPress={() => navigation.navigate('Details', {
            data:data
        })}>
            <ImageBackground style={Styles.background} source={{ uri: 'https://image.tmdb.org/t/p/w200'+data.poster_path }} imageStyle={{ borderRadius: 10 }}>
                <Text style={Styles.source}>{data.release_date}</Text>
                <Text style={Styles.title}>{data.title}</Text>
            </ImageBackground>
        </TouchableOpacity>
    );
}

const Styles = StyleSheet.create({
    title: {
        fontSize: 20,
        color: "yellow",
        fontWeight: "bold",
        padding: 5
    },
    source: {
        fontSize: 20,
        color: "yellow",
        fontWeight: "bold",
        padding: 5,
        alignSelf: "flex-end"
    },
    background: {
        width: "100%",
        height: "100%",
        justifyContent: "space-between"
    },
    container: {
        width: "95%",
        height: 150,
        marginLeft: "2.5%",
        marginRight: "2.5%",
        marginVertical: 5
    }

})

export default NewsCard;