/*
 * Copyright 2014 Nikolay A. Viguro
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.iris.noolite4j;

import ru.iris.noolite4j.receiver.RX2164;
import ru.iris.noolite4j.sender.PC1116;
import ru.iris.noolite4j.watchers.Notification;
import ru.iris.noolite4j.watchers.Watcher;

public class Main {

   public static void main(String[] ARGV)
   {
       PC1116 pc = new PC1116();
       RX2164 rx = new RX2164();

       Watcher watcher = new Watcher() {
           @Override
           public void onNotification(Notification notification) {
               System.out.println("RX2164 получил команду: ");
           }
       };

       byte channel = 1;
       byte level = 85;

       pc.open();
       pc.turnOn(channel);
       pc.turnOff(channel);
       pc.setLevel(channel, level);
       pc.close();

       rx.open();
       rx.addWatcher(watcher);
       rx.start();
   }

}
