import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter, Routes } from '@angular/router';
import { TaskListComponent } from './app/tasks/task-list/task-list.component';
import { TaskFormComponent } from './app/tasks/task-form/task-form.component';
import { TaskDetailsComponent } from './app/tasks/task-details/task-details.component';
import { importProvidersFrom } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

const routes: Routes = [
  { path: '', redirectTo: '/tasks', pathMatch: 'full' },
  { path: 'tasks', component: TaskListComponent },
  { path: 'tasks/new', component: TaskFormComponent },
  { path: 'tasks/:id', component: TaskDetailsComponent },
];

bootstrapApplication(TaskListComponent, {
  providers: [provideRouter(routes), importProvidersFrom(HttpClientModule)],
}).catch(err => console.error(err));