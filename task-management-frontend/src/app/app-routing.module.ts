import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TaskListComponent } from './tasks/task-list/task-list.component';
import { TaskFormComponent } from './tasks/task-form/task-form.component';
import { TaskDetailsComponent } from './tasks/task-details/task-details.component';

const routes: Routes = [
  { path: '', redirectTo: '/tasks', pathMatch: 'full' }, // Redireciona para a lista de tarefas
  { path: 'tasks', component: TaskListComponent }, // Página de lista de tarefas
  { path: 'tasks/new', component: TaskFormComponent }, // Página de criação de nova tarefa
  { path: 'tasks/:id', component: TaskDetailsComponent }, // Página de detalhes de uma tarefa específica
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // Configura as rotas principais
  exports: [RouterModule] // Exporta o RouterModule para uso no AppModule
})
export class AppRoutingModule {}
