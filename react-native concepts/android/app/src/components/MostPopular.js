import React, { useEffect, useState } from 'react';
import { SafeAreaView, Platform, StyleSheet, ActivityIndicator, FlatList } from 'react-native';

import NewsCard from "./NewsCard";

export default function MostPopular(props) {
    console.log("dashboard props", props);
    const [results, setArticles] = useState([]);

    useEffect(() => {
        fetchData();
    }, [])

    const fetchData = async () => {
        const URL = "https://api.themoviedb.org/3/movie/popular?api_key=2f79e3ca254177a578d851938dcaecaf";
        // most popular
        const response = await fetch(URL);
        const data = await response.json();
        setArticles(data.results);
    }

    const renderArticles = () => {
        if (results.length > 0) {
            return (<FlatList
                data={results}
                renderItem={({ item }) => <NewsCard data={item} navigation={props.navigation} />}
                keyExtractor={(item) => item.id.toString()}
                // initialNumToRender={5}
            />)
        }
        return <ActivityIndicator size="large" />
    }

    return (
        <SafeAreaView style={Styles.mainContainer}>
            {renderArticles()}
        </SafeAreaView>
    );
}


const Styles = StyleSheet.create({
    mainContainer: {
        marginTop: Platform.OS === 'android' ? 25 : 0
    }
})