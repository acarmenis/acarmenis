import { Component } from '@angular/core';
import { RequestData } from './RequestData'; 
import { RequestDataService } from './request-data.service'; 
 
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  requestData: RequestData;
  list: requestData.list;

  sendListToBeSorted() {

      this.requestDataService
      .requestToSortList(this.requestData)
      .subscribe((response: UseRequestData) => {
          console.log(response);
      });

  }


}
