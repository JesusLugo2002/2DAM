# -*- coding: utf-8 -*-

from odoo import models, fields, api

class ListaTareas(models.Model):
    _name = 'lista_tareas.lista_tareas'
    _description = 'Lista de tareas'

    tarea = fields.Char(string='Tarea')
    prioridad = fields.Integer(string='Prioridad')
    urgente = fields.Boolean(
        string='Urgente',
        compute='_value_urgente',
        store=True
    )
    realizada = fields.Boolean(string='Realizada')
    # El campo asignado_a lo volví opcional porque pueden existir tareas que no necesariamente
    # estén asignadas para una persona, pues puede no tener importancia quién haga la tarea.
    asignado_a = fields.Many2one('res.users', string='Asignado a', required=False, default=lambda self: self.env.user)
    fecha_limite = fields.Date(string='Fecha límite')
    fecha_creacion = fields.Datetime(string='Fecha de creación', default=fields.Datetime.now(), readonly=True)
    retrasada = fields.Boolean(string='Retrasada', compute='_value_retrasada', store=True)

    @api.depends('prioridad')
    def _value_urgente(self):
        for record in self:
            record.urgente = record.prioridad > 10

    @api.depends('fecha_limite', 'realizada')
    def _value_retrasada(self):
        for record in self:
            if record.fecha_limite:
                record.retrasada = not record.realizada and record.fecha_limite < fields.Date.today()
            else:
                record.retrasada = False

    # Esta función computada es para cambiar el __str__ de la tarea, para no mostrar, por ejemplo,
    # "lista_tareas.lista_tareas.1" sino su título "Estudiar para el examen". (Especialmente
    # para mostrarlo de mejor forma en la vista de calendario).
    #
    # Fuente: Una respuesta en https://www.odoo.com/es/forum/ayuda-1/how-to-display-customer-name-in-calendar-230517
    @api.depends('tarea')
    def _compute_display_name(self):
        for record in self:
            record.display_name = record.tarea