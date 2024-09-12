import React, { useState } from 'react';

function TodoApp() {
  const [tasks, setTasks] = useState([]);
  const [task, setTask] = useState('');

  const addTask = () => {
    if (task) {
      setTasks([...tasks, task]);
      setTask('');
    }
  };

  const removeTask = (index) => {
    const newTasks = tasks.filter((_, i) => i !== index);
    setTasks(newTasks);
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '50px' }}>
      <h1>Lista de Tarefas</h1>
      <input
        type="text"
        value={task}
        onChange={(e) => setTask(e.target.value)}
        placeholder="Adicionar tarefa"
      />
      <button onClick={addTask}>Adicionar</button>

      <ul>
        {tasks.map((task, index) => (
          <li key={index}>
            {task}{' '}
            <button onClick={() => removeTask(index)}>Remover</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TodoApp;
