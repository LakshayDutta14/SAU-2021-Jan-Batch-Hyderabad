
import React from "react";
import { NavigationContainer } from '@react-navigation/native';
import {createStackNavigator} from '@react-navigation/stack';
import screen1 from "./android/app/src/components/screen1";



import Details from "./android/app/src/components/Details";


const Stack=createStackNavigator();

function App() {
  return (
    <NavigationContainer >
      
        <Stack.Navigator>
          <Stack.Screen name='List of Movies' component={screen1}/>
          <Stack.Screen name='Details' component={Details}/>
        </Stack.Navigator>
       
        
    </NavigationContainer>
    
  );
}


  

export default App;

