-- consulta de matrículas

select * from 
nopt.matricula m
join nopt.aluno a on m.aluno_id = a.id
join nopt.disciplina d on m.disciplina_id = d.id 
where m.aluno_id = 232

select * from 
opt.matricula m
join opt.aluno a on m.aluno_id = a.id
join opt.disciplina d on m.disciplina_id = d.id 
where m.aluno_id = 232

-- consulta de quantos alunos por curso

select count(a.id), c.nome 
from nopt.aluno a 
join nopt.curso c on a.curso_id = c.id
group by c.nome 
order by c.nome

select count(a.id), c.nome 
from opt.aluno a 
join opt.curso c on a.curso_id = c.id
group by c.nome 
order by c.nome

-- consulta de total de alunos por curso matriculados em 1 disciplina

select count(a.id), c.nome 
from nopt.aluno a join nopt.curso c on a.curso_id = c.id
where a.id in ( select aluno_id from nopt.matricula m where m.aluno_id = a.id and m.disciplina_id = 150 ) 
group by c.nome 
order by c.nome

select count(a.id), c.nome 
from opt.aluno a join opt.curso c on a.curso_id = c.id
where a.id in ( select aluno_id from opt.matricula m where m.aluno_id = a.id and m.disciplina_id = 150 ) 
group by c.nome 
order by c.nome

-- total de matriculas por periodo em 2015

select count(m.id), ano, periodo from nopt.matricula m 
where ano in (2015,2016,2018) 
group by ano, periodo

select count(m.id), ano, periodo from opt.matricula m 
where ano in (2015,2016,2018) 
group by ano, periodo

-- quantos estão matriculados na disciplina 80 e são do curso de elétrica

select a.id, a.nome, c.nome
from nopt.matricula m 
join nopt.aluno a on m.aluno_id = a.id
join nopt.curso c on a.curso_id = c.id
where m.disciplina_id = 80 and c.id = 2

select a.id, a.nome, c.nome
from opt.matricula m 
join opt.aluno a on m.aluno_id = a.id
join opt.curso c on a.curso_id = c.id
where m.disciplina_id = 80 and c.id = 2



