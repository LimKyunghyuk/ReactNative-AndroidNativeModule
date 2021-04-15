/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, { Component } from 'react';
import { View, Text } from 'react-native';
import NewModuleButton from './NewModuleButton'
class App extends Component{

  render(){
    return (
      <View>
        <Text>Hello world!</Text>
        <NewModuleButton/>
      </View>
    )
  }
}

export default App;
