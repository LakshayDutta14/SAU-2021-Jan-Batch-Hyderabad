
import React from "react";
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';


import Upcoming from "./Upcoming"
import MostPopular from "./MostPopular";
import TopRated from "./TopRated";


const Tab = createBottomTabNavigator();


function screen1() {
  return (
    
      
        <Tab.Navigator  tabBarOptions={{
				activeTintColor: "#50d3a7",
				inactiveTintColor: "black",
				labelStyle: {
					fontSize: 25,
				},
			}}>
          <Tab.Screen   name="Popular" component={MostPopular}  />
          <Tab.Screen name="TopRated" component={TopRated} />
          <Tab.Screen name="Upcoming" component={Upcoming} />
          
        </Tab.Navigator>
       
        
    
    
  );
}


  

export default screen1;

