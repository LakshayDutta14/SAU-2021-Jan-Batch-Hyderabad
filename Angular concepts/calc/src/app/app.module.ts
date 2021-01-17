import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import{FormsModule,ReactiveFormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { NameeditorComponent } from './nameeditor/nameeditor.component';
import { ApicallsComponent } from './apicalls/apicalls.component';
import { Page1Component } from './page1/page1.component';
import{RouterModule, Routes} from '@angular/router';
import { Page2Component } from './page2/page2.component';
import { Page3Component } from './page3/page3.component';

const appRoutes:Routes=[
  {path:' ',component: AppComponent},
  {path:'page1',component: Page1Component},
  {path:'page2',component: Page2Component},
  {path:'page3',component:Page3Component}
]
@NgModule({
  declarations: [
    AppComponent,
    NameeditorComponent,
    ApicallsComponent,
    Page1Component,
    Page2Component,
    Page3Component
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
