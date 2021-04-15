import React from 'react';
import { NativeModules, Button } from 'react-native';

// const { Cal} = NativeModules;

const { CalendarModule } = NativeModules;

const NewModuleButton = () => {
  const onPress = () => {
    console.log('We will invoke the native module here!');

    CalendarModule.createCalendarEvent('테스트 매시지 출력!', 'testLocation');
    

  };

  return (
    <Button
      title="Call Native Toast"
      color="#841584"
      onPress={onPress}
    />
  );
};

export default NewModuleButton;