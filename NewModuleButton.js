import React from 'react';
import { NativeModules, Button } from 'react-native';

// const { Cal} = NativeModules;

const { CalendarModule } = NativeModules;

const NewModuleButton = () => {

  const onPress = () => {
    console.log('We will invoke the native module here!!');

    // CalendarModule.createCalendarEvent('테스트 매시지 출력!', 'testLocation');

    CalendarModule.createCalendarEvent(
      'Party',
      'My House',
      (eventId) => {
        console.log(`Created a new event with id ${eventId}`);
        alert(`Created a new event with id ${eventId}`);
      }
    );
    // CalendarModule.createCalendarEventCallback(
    //   '앱 업데이트',
    //   'testLocation',
    //   (error) => {
    //     console.error(`Error found! ${error}`);
    //   },
    //   (eventId) => {
    //     console.log(`event id ${eventId} returned`);
    //   }
    // );

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