import React from 'react';
import {Text,View,StyleSheet,ImageBackground} from 'react-native'; 

export default function Details(props) {
  const { route, navigation } = props;
  const data=route?.params?.data;
  console.log(data);

  return (
    <ImageBackground style={Styles.background} source={{ uri: 'https://image.tmdb.org/t/p/w200'+data.poster_path }} imageStyle={{ borderRadius: 10 }}>
    <Text style={Styles.source}>{data.release_date}</Text>
    <Text style={Styles.title}>{data.title}</Text>
    <Text style={Styles.overview}>{data.overview}</Text>
</ImageBackground>
  );
}
const Styles = StyleSheet.create({
  title: {
      fontSize: 40,
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
  overview: {
    fontSize: 10,
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